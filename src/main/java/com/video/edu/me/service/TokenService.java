package com.video.edu.me.service;

import com.video.edu.me.dao.TokenMapper;
import com.video.edu.me.entity.Token;
import com.video.edu.me.entity.TokenExample;
import com.video.edu.me.utils.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class TokenService extends BaseService<Token, TokenExample> {

	private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

	private TokenMapper tokenMapper;

	@Resource
	public void setTokenMapper(TokenMapper tokenMapper){
		this.tokenMapper = tokenMapper;
		super.setBaseDao(tokenMapper);
	}

	public int getUserIdByToken(String accessToken){
		TokenExample tokenExample = new TokenExample();
		tokenExample.createCriteria().andAccessTokenEqualTo(accessToken);
		List<Token> tokenList = tokenMapper.selectByExample(tokenExample);
		if (tokenList.size() == 0){
			return -1;
		} else{
			return tokenList.get(0).getUserId();
		}
	}

	public String afterLogin(int userId) throws Exception {
		Token token = null;
		String accessToken = generateToken(userId);
		TokenExample tokenExample = new TokenExample();
		tokenExample.createCriteria().andUserIdEqualTo(userId);
		List<Token> tokenList = tokenMapper.selectByExample(tokenExample);
		if (tokenList.size() == 0){
			token = new Token();
			token.setUserId(userId);
			token.setAccessToken(accessToken);
			tokenMapper.insertSelective(token);
		} else{
			token = tokenList.get(0);
			token.setAccessToken(accessToken);
			tokenMapper.updateByPrimaryKey(token);
		}
		return accessToken;
	}

	private String generateToken(int userId) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		int random = (int)((Math.random()*9+1)*100000);
		long now = System.currentTimeMillis();
		return EncryptUtil.encoderByMd5(String.format("%d-%d-%l", userId, random, now));
	}
}
