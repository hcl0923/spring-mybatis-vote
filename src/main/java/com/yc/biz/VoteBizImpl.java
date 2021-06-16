package com.yc.biz;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Vote;
import com.yc.dao.OptionMapper;
import com.yc.dao.VoteMapper;
import com.yc.util.VoteUtil;
@Service
public class VoteBizImpl implements IVoteBiz {
	@Autowired
	VoteMapper mapper;
	
	@Autowired
	OptionMapper optionMapper;
	@Transactional
	@Override
	public int add(Vote vote, String[] options) {
		String vid=VoteUtil.genVid();
		vote.setVid(vid);
		int i=mapper.add(vote);
		List<String> list=Arrays.asList(options);
		int j=optionMapper.addOptions(list, vid);
		
		//以上两个操作都成功，才会进行事务提交，否则会进行事务回滚
		if(i>0&&j>0) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		return null;
	}

	@Override
	public Map<String, Object> findByVid(String vid) {
		return null;
	}

}
