package com.hnkypg.dao;

import com.hnkypg.pojo.BaoGao;
import com.hnkypg.pojo.Count;
import com.hnkypg.pojo.Tontjia;
import com.hnkypg.pojo.sreach;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by python on 2017-6-15.
 */
public class TongJiDao {

    public void insertTj(List<Count> cts){
        int temp =0;
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
            for(int i=0;i<cts.size();i++){
                temp = session.insert("insertTj",cts.get(i));

            }
            session.commit();
			System.out.println(temp);
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

    public void deltjbybglid(int bglid){

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
                session.delete("deltjbybglid",bglid);
                session.commit();

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
    }


    public List<Tontjia> tongjiall(sreach sreach ){
        List<Tontjia> tjall = new ArrayList<>();
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
            tjall = session.selectList("tongjiall",sreach);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return  tjall;
    }

    public int  Counttongjiall(){
        int temp =0;
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

            temp = session.selectOne("Counttongjiall");
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

    public List<Tontjia> tongjicheck(sreach sreach ){
        List<Tontjia> tjall = new ArrayList<>();
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
            tjall = session.selectList("tongjicheck",sreach);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return  tjall;
    }

    public int  Counttongjicheck(sreach s){
        int temp =0;
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

            temp = session.selectOne("Counttongjicheck",s);
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

    public List<Tontjia> tubiaocheck(sreach sreach ){
        List<Tontjia> tjall = new ArrayList<>();
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
            tjall = session.selectList("tubiaocheck",sreach);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return  tjall;
    }
}


