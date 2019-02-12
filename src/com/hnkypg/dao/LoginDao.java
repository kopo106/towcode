package com.hnkypg.dao;


import com.hnkypg.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


/**
 * Created by Administrator on 2017/4/9 0009.
 */
public class LoginDao {
    public User login(String loginname,String password){
        User temp = new User();
        User user=new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        // TODO Auto-generated method stub
        String resource = "com/hnkypg/map/MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        session = sqlMapper.openSession();
        try{

            //对象传入参数测试

			temp = session.selectOne("userlogin",user);
//			System.out.println(temp.getBumen());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return temp;
    }
    public User loginaaa(String loginname,String password){
        User u1 = new User();
        User u2 = new User();
        u2.setLoginname(loginname);
        u2.setPassword(password);
        // TODO Auto-generated method stub
        String resource = "com/hnkypg/map/MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        session = sqlMapper.openSession();
        try{
            u1 = session.selectOne("finduserlogin",u2);//查询可能是2条记录
//            System.out.println(u1.getBumen()+"++++++++++++++++++++++++++++++++++----------");
//			System.out.println(temp.getBumen());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return u1;
    }

    public void updateuserps(User user){

        // TODO Auto-generated method stub
        String resource = "com/hnkypg/map/MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        session = sqlMapper.openSession();
        try{
            session.update("updateuserps",user);//查询可能是2条记录
            session.commit();
			System.out.println("修改成功了没");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }

    }

}
