package member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MemberDAOmyBatis extends SqlSessionDaoSupport
							implements MemberDAO {

	@Override
	public MemberDTO loginArticle(String id, String pwd) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("pwd",pwd);
		
		return (MemberDTO)getSqlSession().selectOne("loginArticle",map);           
	}

	@Override
	public void insertMember(MemberDTO memberDTO) throws Exception {

		getSqlSession().insert("insertMember",memberDTO);
	}

	@Override
	public String checkId(String id) {
		return (String)getSqlSession().selectOne("checkId", id);
	}

	@Override
	public List<ZipcodeDTO> getZipcodeList(String dong) {
		return getSqlSession().selectList("getZipcodeList", dong);
	}

	@Override
	public String getUserPwd(String username) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("getUserPwd",username);
	}
	

}










