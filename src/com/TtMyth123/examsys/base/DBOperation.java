package com.TtMyth123.examsys.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.TtMyth123.examsys.bean.ChapterInfo;
import com.TtMyth123.examsys.bean.SourceInfo;

public class DBOperation {
	private SQLiteDatabase m_SQLiteDatabase;
	private Context m_context;
	private static final String DB_NAME = "ExamSysDB.db";
	private static final String ASSET_DB_PATH = "db/" + DB_NAME;
	private final int BUFFER_SIZE = 400000;

	private String SOURCE_TABLE = "SOURCE";
	private String CHAPTER_TABLE = "Chapter";
	private static final String PACKAGE_NAME = "com.TtMyth123.examsys";
	private static final String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/"
			+ PACKAGE_NAME + "/" + DB_NAME; // 在手机里存放数据库的位置(/data/data/com.TtMyth123.examsys/ExamSysDB.db)

	public DBOperation(Context context) {
		m_context = context;

		m_SQLiteDatabase = openDatabase(DB_PATH);
	}

	/**
	 * 打开数据库，根据文件名。
	 * 
	 * @param dbfile
	 *            数据库文件名。
	 * @return 数据库实例。
	 */
	private SQLiteDatabase openDatabase(String dbfile) {
		Log.i("TtTest", "openDatabase begin");
		SQLiteDatabase db = null;
		try {
			if (!(new File(dbfile).exists())) {
				Log.i("TtTest", "openDatabase ASSET_DB_PATH:" + ASSET_DB_PATH);
				// 判断数据库文件是否存在，若不存在则执行导入，否则直接打开数据库
				InputStream is = this.m_context.getAssets().open(ASSET_DB_PATH); // 欲导入的数据库

				FileOutputStream fos = new FileOutputStream(dbfile);
				byte[] buffer = new byte[BUFFER_SIZE];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					fos.write(buffer, 0, count);
				}
				fos.close();
				is.close();
				Log.i("TtTest", "openDatabase writed");
			}
			Log.i("TtTest", "openDatabase dbfile:" + dbfile);
			db = SQLiteDatabase.openOrCreateDatabase(dbfile, null);
		} catch (FileNotFoundException e) {
			Log.e("TtTest", "File not found");
			e.printStackTrace();
		} catch (IOException e) {
			Log.e("TtTest", "IO exception");
			e.printStackTrace();
		} catch (Exception e) {
			Log.e("TtTest", "exception");
			e.printStackTrace();
		}

		Log.i("TtTest", "openDatabase end");
		return db;
	}

	/**
	 * 获取全部的试卷源类型。
	 * 
	 * @return 试卷源类型
	 */
	public List<SourceInfo> getAllSourceInfo() {
		Log.i("TtTest", "getAllSourceInfo begin");
		List<SourceInfo> sourceInfoList = new ArrayList<SourceInfo>();
		String sql = MessageFormat.format("Select * from {0}", new Object[] { SOURCE_TABLE });;
		Cursor cursor = m_SQLiteDatabase.rawQuery(sql, null);

		while (cursor.moveToNext()) {
			SourceInfo sourceInfo = new SourceInfo();
			sourceInfo.setSortID(cursor.getInt(cursor.getColumnIndex("Sortid")));
			sourceInfo.setSrcID(cursor.getInt(cursor.getColumnIndex("Srcid")));
			sourceInfo.setSource(cursor.getString(cursor.getColumnIndex("Source")));
			sourceInfoList.add(sourceInfo);
		}

		Log.i("TtTest", "getAllSourceInfo end");
		return sourceInfoList;
	}

	public List<ChapterInfo> getChapterInfo(int srcID) {
		Log.i("TtTest", "getChapterInfo begin");
		List<ChapterInfo> sourceInfoList = new ArrayList<ChapterInfo>();
		String sql = MessageFormat.format("Select * from {0} where SrcID=?", new Object[] { CHAPTER_TABLE });;
		Cursor cursor = m_SQLiteDatabase.rawQuery(sql, new String[] { String.valueOf(srcID) });

		while (cursor.moveToNext()) {
			ChapterInfo chapterInfo = new ChapterInfo();
			chapterInfo.copyValue(cursor);
			sourceInfoList.add(chapterInfo);
		}

		Log.i("TtTest", "getChapterInfo end sourceInfoList.count=" + sourceInfoList.size());
		return sourceInfoList;
	}
}
