package com.TtMyth123.examsys;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.TtMyth123.examsys.base.DBOperation;
import com.TtMyth123.examsys.base.SimpleNewMessageBuilder;
import com.TtMyth123.examsys.bean.ChapterInfo;
import com.TtMyth123.examsys.bean.SourceInfo;

/**
 * 试卷选择
 * 
 * @author S5
 * 
 */
public class ExaminationPaperActivity extends Activity {
	private Gallery mGallery;
	private Button buttonOpenExaminationIntro;
	private DBOperation dbOperation;
	private ListView listViewExamination;
	private ViewExaminationAdapter viewExaminationAdapter;
	private AsyncImageAdapter asyncImageAdapter;
	private int selectPosition = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.examinationpaper_layout);
		dbOperation = new DBOperation(this);

		iniGalleryExaminationPaperType();
		iniButtonOpenExaminationIntro();

	}

	private void loadChapterBySrcID(int srcID) {
		List<ChapterInfo> lstChapter = dbOperation.getChapterInfo(srcID);
		try {
			listViewExamination = (ListView) findViewById(R.id.listViewExamination);
			viewExaminationAdapter = new ViewExaminationAdapter(ExaminationPaperActivity.this, 0, lstChapter);
			listViewExamination.setAdapter(viewExaminationAdapter);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listViewExamination.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				selectPosition = position;
			}
		});

	}

	private void iniButtonOpenExaminationIntro() {
		buttonOpenExaminationIntro = (Button) findViewById(R.id.buttonOpenExaminationIntro);
		buttonOpenExaminationIntro.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// ChapterInfo chapterInfo = (ChapterInfo) listViewExamination.getSelectedItem();
				// int position = listViewExamination.getSelectedItemPosition();
				if (selectPosition >= 0) {
					Log.i("TtTest", "ButtonOpenExaminationIntro onClick position=" + selectPosition);
					ChapterInfo chapterInfo = viewExaminationAdapter.getItem(selectPosition);
					Intent intentOpenExaminationIntro = new Intent(ExaminationPaperActivity.this,
							ExaminationIntroActivity.class);

					chapterInfo.toValue(intentOpenExaminationIntro);
					ExaminationPaperActivity.this.startActivity(intentOpenExaminationIntro);
				} else {
					Toast.makeText(buttonOpenExaminationIntro.getContext(), R.string.MSG_NOExam, 1000).show();
				}
			}
		});
	}

	private void iniGalleryExaminationPaperType() {
		mGallery = (Gallery) findViewById(R.id.galleryExaminationType);

		List<SourceInfo> lstSource = dbOperation.getAllSourceInfo();
		try {
			ArrayList<Object> sourceInfoList = new ArrayList<Object>();
			for (int i = 0; i < lstSource.size(); i++) {
				sourceInfoList.add(lstSource.get(i));
			}
			asyncImageAdapter = new AsyncImageAdapter(this, sourceInfoList);
			mGallery.setAdapter(asyncImageAdapter);
			mGallery.setSelection(sourceInfoList.size() / 2);// 选择中间的项目
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mGallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position, long id) {
				SourceInfo sourceInfo = (SourceInfo) asyncImageAdapter.getItem(position);
				loadChapterBySrcID(sourceInfo.getSrcID());
				// testImageView.this.setTitle(String.valueOf(position));
			}
		});
	}

	public class ViewExaminationAdapter extends ArrayAdapter<ChapterInfo> {
		Context m_context;
		List<ChapterInfo> dataS;

		public ViewExaminationAdapter(Context context, int textViewResourceId, List<ChapterInfo> dataSource) {
			super(context, textViewResourceId, dataSource);
			m_context = context;
			dataS = dataSource;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			LinearLayout linearLayout = new LinearLayout(m_context);
			linearLayout.setOrientation(LinearLayout.VERTICAL);
			TextView textView = new TextView(m_context);
			ChapterInfo chapterInfo = getItem(arg0);
			textView.setText(chapterInfo.getChapter());
			linearLayout.addView(textView);

			return linearLayout;
		}

	}

	public class AsyncImageAdapter extends BaseAdapter {
		Context m_context;
		List<Object> dataS;

		public AsyncImageAdapter(Context context, List<Object> dataSource) {
			m_context = context;
			dataS = dataSource;
		}

		Handler downImageHander = new Handler() {
			public void handleMessage(Message msg) {
				String msgValue = SimpleNewMessageBuilder.getSimpleMessage(msg);

				ImageView imageView = (ImageView) msg.obj;
				try {
					Bitmap a = getImageFromAssetsFile(imageView.getContext(), msgValue);
					imageView.setImageBitmap(a);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			/**
			 * 重写这个方法。这是加载图片的方法 .
			 * 
			 * @param context
			 *            上下文。
			 * @param msgValue
			 *            消息值.根据消息值装载图片。信息值 在getView中的downImage传入。
			 * @return 返回图片
			 * @throws IOException
			 *             异常.
			 */
			public Bitmap getImageFromAssetsFile(Context context, String msgValue) throws IOException {
				String fileName = getFileName(msgValue);
				Bitmap image = null;
				AssetManager am = context.getResources().getAssets();

				InputStream is = am.open(fileName);
				try {
					image = BitmapFactory.decodeStream(is);
				} finally {
					is.close();
				}
				return image;
			}

			private String getFileName(String msgValue) {
				String fileName = "source/" + msgValue + ".png";
				// String fileName = msgValue+".png";
				return fileName;
			}
		};

		private void downImage(final ImageView imageView, final String imageID) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Message msg = SimpleNewMessageBuilder.createSimpleMessage(imageID);
					msg.obj = imageView;
					downImageHander.sendMessage(msg);

				}
			}).start();
		}

		@Override
		public int getCount() {

			return dataS.size();
		}

		@Override
		public Object getItem(int arg0) {
			return dataS.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			LinearLayout linearLayout = new LinearLayout(m_context);
			linearLayout.setOrientation(LinearLayout.VERTICAL);
			TextView textView = new TextView(m_context);
			linearLayout.addView(textView);
			ImageView imageView = new ImageView(m_context);
			imageView.setLayoutParams(new LayoutParams(250, 250));
			linearLayout.addView(imageView);

			SourceInfo sourceInfo = (SourceInfo) dataS.get(arg0);
			String imageID = String.valueOf(sourceInfo.getSrcID());
			downImage(imageView, imageID);
			return linearLayout;
		}

	}

}
