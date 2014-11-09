package member.service;

import java.util.List;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberDTO loginArticle(String id, String pwd) {
		return memberDAO.loginArticle(id, pwd);
	}

	@Override
	public void insertMember(MemberDTO memberDTO) throws Exception {
		memberDAO.insertMember(memberDTO);
	}

	@Override
	public String checkId(String id) {
		return memberDAO.checkId(id);
	}

	@Override
	public List<ZipcodeDTO> getZipcodeList(String dong) {
		return memberDAO.getZipcodeList(dong);
	}

	@Override
	public String getUserPwd(String username) {
		return memberDAO.getUserPwd(username);
	}

}
