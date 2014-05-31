package com.TtMyth123.examsys.bean;

import java.util.List;

/**
 * สิฬโ.
 * @author S5
 *
 */
public class Topic {
	/** @pdOid 80e92ef2-35cc-4ef5-9ba8-2ce5877ec307 */
	private double score;
	/** @pdOid 7663fe54-40c0-4254-a1bd-6524a9bc33c1 */
	private Object answer;
	/** @pdOid 2d5c54ab-9443-4d6a-bc81-0aee6ec1b6a4 */
	private Object result;
	
	
	   
	public double getScore() {
		return score;
	}


	public void setScore(double score) {
		this.score = score;
	}


	public Object getAnswer() {
		if (answer==null) {
			answer = "";
		}
		return answer;
	}


	public void setAnswer(Object answer) {
		this.answer = answer;
	}


	public Object getResult() {
		return result;
	}


	public void setResult(Object result) {
		this.result = result;
	}

	/** @pdRoleInfo migr=no name=SubItemTitle assc=association1 coll=java.util.List mult=0..* type=Composition */
	   public java.util.List<SubItemTitle> subItemTitle;
	   
	   /** @pdOid c930f7b8-00f9-424c-8ca7-335829bd9be1 */
	   public boolean comparison() {
	      // TODO: implement
	      return false;
	   }
	   
	   
	   /** @pdGenerated default getter */
	   public java.util.List<SubItemTitle> getSubItemTitle() {
	      if (subItemTitle == null)
	         subItemTitle = new java.util.Vector<SubItemTitle>();
	      return subItemTitle;
	   }
	   
	   /** @pdGenerated default iterator getter */
	   public java.util.Iterator getIteratorSubItemTitle() {
	      if (subItemTitle == null)
	         subItemTitle = new java.util.Vector<SubItemTitle>();
	      return subItemTitle.iterator();
	   }
	   
	   /** @pdGenerated default setter
	     * @param newSubItemTitle */
	   public void setSubItemTitle(java.util.List<SubItemTitle> newSubItemTitle) {
	      removeAllSubItemTitle();
	      for (java.util.Iterator iter = newSubItemTitle.iterator(); iter.hasNext();)
	         addSubItemTitle((SubItemTitle)iter.next());
	   }
	   
	   /** @pdGenerated default add
	     * @param newSubItemTitle */
	   public void addSubItemTitle(SubItemTitle newSubItemTitle) {
	      if (newSubItemTitle == null)
	         return;
	      if (this.subItemTitle == null)
	         this.subItemTitle = new java.util.Vector<SubItemTitle>();
	      if (!this.subItemTitle.contains(newSubItemTitle))
	         this.subItemTitle.add(newSubItemTitle);
	   }
	   
	   /** @pdGenerated default remove
	     * @param oldSubItemTitle */
	   public void removeSubItemTitle(SubItemTitle oldSubItemTitle) {
	      if (oldSubItemTitle == null)
	         return;
	      if (this.subItemTitle != null)
	         if (this.subItemTitle.contains(oldSubItemTitle))
	            this.subItemTitle.remove(oldSubItemTitle);
	   }
	   
	   /** @pdGenerated default removeAll */
	   public void removeAllSubItemTitle() {
	      if (subItemTitle != null)
	         subItemTitle.clear();
	   }

	}