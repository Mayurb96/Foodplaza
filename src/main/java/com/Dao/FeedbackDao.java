package com.Dao;

import java.util.List;

import com.pojo.FeedBack;

public interface FeedbackDao {
	 
	boolean addFeedback(FeedBack fd);
	List<FeedBack>getAllFeedback();

}
