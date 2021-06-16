package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.Vote;

public interface IVoteBiz {
	public int add(Vote vote,String[] options);
	public List<Map<String,Object>> findAll();
	public Map<String,Object> findByVid(String vid);
}
