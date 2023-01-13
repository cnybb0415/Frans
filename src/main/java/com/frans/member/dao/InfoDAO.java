package com.frans.member.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.frans.member.dto.MemberDTO;

@Mapper
public interface InfoDAO {

	ArrayList<MemberDTO> infoTeamList();

	ArrayList<MemberDTO> infoPosList();

	ArrayList<MemberDTO> infoDutyList();

	ArrayList<MemberDTO> infoList();
	
	ArrayList<MemberDTO> teamList();

	ArrayList<MemberDTO> dutyList();

	ArrayList<MemberDTO> posList();

	void teamWrite(HashMap<String, String> params);

	void posWrite(HashMap<String, String> params);

	void dutyWrite(HashMap<String, String> params);

	int subCount();

	MemberDTO teamUpdateForm(String team_idx);

	void teamUpdate(HashMap<String, String> params);










}
