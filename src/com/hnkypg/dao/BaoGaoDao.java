package com.hnkypg.dao;

import com.hnkypg.Util.Countset;
import com.hnkypg.pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by python on 2017/4/17 0017.
 */
public class BaoGaoDao {
    public int insertbaogao(BaoGao bg){

        // TODO Auto-generated method stub
        String resource = "com/hnkypg/map/MyBatisConfig.xml";
        Reader reader = null;
        int temp = 0;
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

            temp = session.insert("insertbg",bg);
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
        return temp;
    }

    public int insertbaogaolist(BaoGaoList bgl){

        // TODO Auto-generated method stub
        String resource = "com/hnkypg/map/MyBatisConfig.xml";
        Reader reader = null;
        int temp = 0;
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

            temp = session.insert("insertbgl",bgl);
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
        return temp;
    }
    public List<BaoGaoList> bglist(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoList",sreach);
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


    public List<BaoGaoList> bglistdown(){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("bglistdown");
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

    public List<BaoGaoList> bglistbyquyu(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("bglistbyquyu",sreach);
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
    public List<BaoGaoList> bglistbydate(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbydate",sreach);
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

    public List<BaoGaoList> bglistbydatedown(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("bglistbydatedown",sreach);
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
    public List<BaoGaoList> fgsbglbydatequyu(sreach s){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("fgsbglbydatequyu",s);
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

    public int allcounts(){
        int counts = 0;
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
            counts = session.selectOne("allcounts");
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
        return counts;
    }

    public int allcountsdown(){
        int counts = 0;
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
            counts = session.selectOne("allcounts");
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
        return counts;
    }

    public int allcountsbyquyu(sreach s){
        int counts = 0;
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
            counts = session.selectOne("allcountsbyquyu",s);
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
        return counts;
    }

    public int allcountsbydate(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountsbydate",sreach);
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
        return counts;
    }

    public int allcountsbydatedown(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountsbydatedown",sreach);
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
        return counts;
    }

    public int allcountsbydatequyu(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountsbydatequyu",sreach);
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
        return counts;
    }

    public BaoGao findbaogobybgid(int bgid){
        BaoGao bg = new BaoGao();
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
            bg = session.selectOne("findbaogobybgid",bgid);
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
        return bg;
    }

    public int findbgidbystrave(String bgnum){
        int bgid = 0;
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
            bgid = session.selectOne("findbgidbystrave",bgnum);
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
        return bgid;
    }

    public int findbglidbystrave(String bgnum){
        int bglid = 0;
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
            bglid = session.selectOne("findbglidbystrave",bgnum);
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
        return bglid;
    }

    public List<BaoGaoList> findbglsbybgnum(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("findbglsbybgnum",sreach);//查询可能是2条记录
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

    public List<BaoGaoList> findbglsbybgnumquyu(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("findbglsbybgnumquyu",sreach);//查询可能是2条记录
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

    public int allcountsbybgnum(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountsbybgnum",sreach);
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
        return counts;
    }

    public int allcountsbybgnumquyu(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountsbybgnumquyu",sreach);
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
        return counts;
    }

    public List<BaoGaoList> bglistbyzuoluo(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyzuoluo",sreach);
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


    public List<BaoGaoList> selectbglbyzuoluoqy(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectbglbyzuoluoqy",sreach);
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

    public int allcountsbyzuoluo(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountsbyzuoluo",sreach);
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
        return counts;
    }

    public int allcountsbyzuoluoquy(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountsbyzuoluoquy",sreach);
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
        return counts;
    }

    public List<BaoGaoList> selectBaoGaoListbyzldate(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyzldate",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbyzldatequyu(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyzldatequyu",sreach);
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

    public List<BaoGaoList> selectbglbyzldatequyu(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectbglbyzldatequyu",sreach);
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

      public int allcountsbyzldate(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountsbyzldate",sreach);
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
        return counts;
    }

    public int allcountsbyzldateqy(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountsbyzldateqy",sreach);
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
        return counts;
    }


    public BaoGaoList findbglbyid(int bglid){
        BaoGaoList temp = new BaoGaoList();
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
            temp = session.selectOne("findbglbyid",bglid);
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

    public void updatebglbybglid(BaoGaoList bgl){
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
            session.update("updatebglbybglid",bgl);
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

    public void updatebgbybgid(BaoGao bg){
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
            session.update("updatebgbybgid",bg);
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

    public void updatebglstatebyid(int bglid){
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
            session.update("updatebglstatebyid",bglid);
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

    public int findbgidbybunum(String bgnum){
        int bgid = 0;
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
            bgid = session.selectOne("findbgidbybunum",bgnum);
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
        return bgid;
    }

    public int findbglidbybunum(String bgnum){
        int bglid = 0;
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
            bglid = session.selectOne("findbglidbybunum",bgnum);
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
        return bglid;
    }


    public List<tongji> tongjibyuserid(User user){
        List<tongji> tj = new ArrayList<tongji>();
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
            tj = session.selectList("tongjibyuserid",user);
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
        return tj;
    }

    public void insertyppl(List<BaoGao> bgs,List<BaoGaoList> bgls){


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
            for(int i=0;i<bgls.size();i++){
                session.insert("insertbgl",bgls.get(i));
            }
            for(int j = 0; j<bgs.size();j++){
                session.insert("insertbg",bgs.get(j));
            }
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


    public int insertbaogaos(List<BaoGao> bgs){

        // TODO Auto-generated method stub
        String resource = "com/hnkypg/map/MyBatisConfig.xml";
        Reader reader = null;
        int temp = 0;
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
            for(int i = 0; i<bgs.size();i++){
                temp = session.insert("insertbg",bgs.get(i));
            }
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

        return temp;
    }

    public List<BaoGao> findbgsbybglid(int bglid){
        List<BaoGao> bgs = new ArrayList<BaoGao>();
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
            bgs = session.selectList("findbgsbybglid",bglid);//查询可能是2条记录
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
        return bgs;
    }

    public void delbgbybglid(int bglid){

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
            session.delete("delbgbybglid",bglid);
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

    public List<BaoGaoList> selectBaoGaoListbyproname(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyproname",sreach);
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

    public List<BaoGaoList> selectbglbypronameqy(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectbglbypronameqy",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbycqr(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbycqr",sreach);
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

    public List<BaoGaoList> selectbglbycqrquyu(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectbglbycqrquyu",sreach);
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


    public int countbycqr(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbycqr",sreach);
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
        return counts;
    }

    public int countbycqrquyu(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbycqrquyu",sreach);
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
        return counts;
    }

    public List<BaoGaoList> selectBaoGaoListbyzxorjszx(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyzxorjszx",sreach);
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


    public List<BaoGaoList> selectBaoGaoListbylaiyuan(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbylaiyuan",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbyzxorjszxall(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyzxorjszxall",sreach);
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

    public int countbyzxorjszx(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyzxorjszx",sreach);
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
        return counts;
    }


    public int countbylaiyuan(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbylaiyuan",sreach);
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
        return counts;
    }

    public int countbyzxorjszxall(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyzxorjszxall",sreach);
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
        return counts;
    }

    public int allcountBaoGaoListbyproname(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountBaoGaoListbyproname",sreach);
			System.out.println(counts+"多少行");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return counts;
    }

    public int allcountbglbypronameqy(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountbglbypronameqy",sreach);
            System.out.println(counts+"多少行");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return counts;
    }

    public List<BaoGaoList> selectbgls(){
        List<BaoGaoList> bgls = new ArrayList<>();
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
            bgls = session.selectList("selectbgls");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return bgls;
    }

    public List<BaoGaoList> selectbglsbyid(){
        List<BaoGaoList> bgls = new ArrayList<>();
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
            bgls = session.selectList("selectbglsbyid");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return bgls;
    }

    public List<BaoGao> selectbgsbynull(){
        List<BaoGao> bgs = new ArrayList<>();
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
            bgs = session.selectList("selectbgsbynull");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return bgs;
    }

    public void updatebgbglid(List<BaoGao> bgs){


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
            for(int j = 0; j<bgs.size();j++){
                if(bgs.get(j).getBglid()!=0){
                    session.update("updatebgbglid",bgs.get(j));
                }
            }
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

    public List<BaoGaoList> findbglsbybgnumanddate(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("findbglsbybgnumanddate",sreach);
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

    public int allcountsbybgnumanddate(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountsbyzldate",sreach);
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
        return counts;
    }

    public int countbyzporsd(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyzporsd",sreach);
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
        return counts;
    }

    public int countbyzporsdall(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyzporsdall",sreach);
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
        return counts;
    }

    public int countbyshdown(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyshdown",sreach);
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
        return counts;
    }

    public int countbyshdownall(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyshdownall",sreach);
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
        return counts;
    }

    public int countbyjzdown(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyjzdown",sreach);
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
        return counts;
    }

    public int countbyjzdownall(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyjzdownall",sreach);
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
        return counts;
    }


    public int countbydjdown(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbydjdown",sreach);
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
        return counts;
    }

    public int countbydjdownall(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbydjdownall",sreach);
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
        return counts;
    }

    public int allcountsbyzldatequyu(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountsbyzldatequyu",sreach);
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
        return counts;
    }

    public List<BaoGaoList> selectBaoGaoListbypronameanddate(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbypronameanddate",sreach);
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

    public List<BaoGaoList> selectbglbypronameanddateqy(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectbglbypronameanddateqy",sreach);
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
    public int allcountBaoGaoListbypronameandate(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountBaoGaoListbypronameandate",sreach);
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
        return counts;
    }

    public int allcountbglbypronameandateqy(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("allcountbglbypronameandateqy",sreach);
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
        return counts;
    }

    public List<BaoGaoList> selectBaoGaoListbycqranddate(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbycqranddate",sreach);
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

    public List<BaoGaoList> selectbglbycqranddateqy(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectbglbycqranddateqy",sreach);
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

    public int countbycqrandate(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbycqrandate",sreach);
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
        return counts;
    }

    public int countbycqrandatequyu(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbycqrandatequyu",sreach);
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
        return counts;
    }

    public List<BaoGaoList> selectBaoGaoListbyzxorjszxdate(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyzxorjszxdate",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbylaiyuandate(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbylaiyuandate",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbyzxorjszxdateall(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyzxorjszxdateall",sreach);
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


    public List<BaoGaoList> selectBaoGaoListbyzporsddate(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyzporsddate",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbyzporsddatedownall(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyzporsddatedownall",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbyshdowndate(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyshdowndate",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbyshdowndateall(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyshdowndateall",sreach);
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


    public List<BaoGaoList> selectjzdownbydate(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectjzdownbydate",sreach);
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

    public List<BaoGaoList> selectjzdownbydateall(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectjzdownbydateall",sreach);
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

    public List<BaoGaoList> selectdjdownbydate(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectdjdownbydate",sreach);
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

    public List<BaoGaoList> selectdjdownbydateall(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectdjdownbydateall",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbyzporsd(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyzporsd",sreach);
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


    public List<BaoGaoList> selectBaoGaoListbyzporsddwall(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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
            temp = session.selectList("selectBaoGaoListbyzporsddwall",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbyshdown(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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

            temp = session.selectList("selectBaoGaoListbyshdown",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbyshdownall(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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

            temp = session.selectList("selectBaoGaoListbyshdownall",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbyjzdown(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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

            temp = session.selectList("selectBaoGaoListbyjzdown",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbyjzdownall(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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

            temp = session.selectList("selectBaoGaoListbyjzdownall",sreach);
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


    public List<BaoGaoList> selectBaoGaoListbydjdown(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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

            temp = session.selectList("selectBaoGaoListbydjdown",sreach);
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

    public List<BaoGaoList> selectBaoGaoListbydjdownall(sreach sreach){
        List<BaoGaoList> temp = new ArrayList<BaoGaoList>();
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

            temp = session.selectList("selectBaoGaoListbydjdownall",sreach);
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

    public int countbyzxorjszxdate(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyzxorjszxdate",sreach);
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
        return counts;
    }

    public int countbylaiyuandate(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbylaiyuandate",sreach);
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
        return counts;
    }

    public int countbyzxorjszxdateall(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyzxorjszxdateall",sreach);
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
        return counts;
    }

    public int countbyzporsddate(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyzporsddate",sreach);
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
        return counts;
    }

    public int countbyzporsddateall(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyzporsddateall",sreach);
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
        return counts;
    }


    public int countbyshdownddate(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyshdownddate",sreach);
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
        return counts;
    }

    public int countbyshdownddateall(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyshdownddateall",sreach);
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
        return counts;
    }


    public int countbyjzdowndate(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyjzdowndate",sreach);
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
        return counts;
    }

    public int countbyjzdowndateall(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbyjzdowndateall",sreach);
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
        return counts;
    }


    public int countbydjdowndate(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbydjdowndate",sreach);
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
        return counts;
    }

    public int countbydjdowndateall(sreach sreach){
        int counts = 0;
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
            counts = session.selectOne("countbydjdowndateall",sreach);
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
        return counts;
    }

    public void updatectstates(List<BaoGaoList> bgls){
        int counts = 0;
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
            for (int i =0;i<bgls.size();i++){
                session.update("updatectstates",bgls.get(i));
            }
            session.commit();

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

    public List<Tontjia> tongjiquanyebgl(sreach s,List<Tontjia> tjas){
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
            float zhuanxie = 0;
            float jszx = 0;
            float zpkc = 0;
            float sdkc = 0;
            float shenhe = 0;
            float jzgt = 0;
            float dingjia = 0;
            float fgs =0;
            for(int i = 0; i < tjas.size();i++ ){
                s.setUser(tjas.get(i).getUser());
                tjas.get(i).setZhuanxie(session.selectOne("countzhuanxietj",s));
                tjas.get(i).setJszhuanxie(session.selectOne("countjszhuanxietj",s));
                tjas.get(i).setKancha(session.selectOne("countkanchatj",s));
                tjas.get(i).setShidikc(session.selectOne("countshidikctj",s));
                tjas.get(i).setFgs(session.selectOne("countfgstj",s));
                shenhe = session.selectOne("countshenhetj",s);
                fgs = tjas.get(i).getFgs();
                if(tjas.get(i).getBaogaotype().equals("正式报告")&& shenhe > 0){
                    shenhe = shenhe - fgs;
                }
                tjas.get(i).setShenhe(shenhe);
                tjas.get(i).setJiazhigoutong(session.selectOne("countjiazhigoutongtj",s));
                tjas.get(i).setDingjia(session.selectOne("countdingjiatj",s));

            }

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
        return tjas;
    }



    public BaoGaoList findbglbyidss(int bglid){
        BaoGaoList bgl = new BaoGaoList();
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

            bgl = session.selectOne("findbglbyidss",bglid);

            session.commit();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return bgl;
    }



    public List<BaoGao> findbgsbybglidss(int bglid){
        List<BaoGao> temp = new ArrayList<BaoGao>();
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

            temp = session.selectList("findbgsbybglidss",bglid);
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

}

