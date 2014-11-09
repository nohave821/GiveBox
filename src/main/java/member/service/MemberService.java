package member.service;

import java.util.List;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public interface MemberService {
	
	MemberDTO loginArticle(String id, String pwd);

	void insertMember(MemberDTO memberDTO) throws Exception;

	String checkId(String id);

	List<ZipcodeDTO> getZipcodeList(String dong);

	String getUserPwd(String username);
}
