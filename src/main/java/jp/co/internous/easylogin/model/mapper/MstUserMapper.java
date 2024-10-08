package jp.co.internous.easylogin.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.easylogin.model.domain.MstUser;


@Mapper
public interface MstUserMapper {
	
	@Select("SELECT * FROM mst_user WHERE user_name = #{userName} AND password = #{password}")
	MstUser findByUserNameAndPassword(String userName,String password);
	
}
//4each_P19：https://4each.jp/challenges/springboot-lesson06/springboot62
//補足：データベースにアクセスする為のメソッドについては、Lesson07を見ましょう
//「Mapper」インターフェースはdao(DataAccessObject)であり、
//データベースにアクセスする役割を持っています。
