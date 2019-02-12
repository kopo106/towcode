package com.hnkypg.dao;

import com.hnkypg.pojo.BaoGao;
import com.hnkypg.pojo.BaoGaoList;
import com.hnkypg.pojo.fgsbgl;
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
 * Created by python on 2017-8-17.
 */
public class fgsDao {


    public int insertfgsbgl(fgsbgl bgl){

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

            temp = session.insert("insertfgsbgl",bgl);
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

    public int findfgsbglidbybunum(String bgnum){

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

            temp = session.selectOne("findfgsbglidbybunum",bgnum);
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

    public int findfgscountbybunum(String bgnum){

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

            temp = session.selectOne("findfgscountbybunum",bgnum);
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

    public void insertfgsbgs(List<BaoGao> bgs){

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

            for(int i = 0; i < bgs.size(); i++){
                session.insert("insertfgsbgs",bgs.get(i));
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

    public List<fgsbgl> fgsbglistbydate(sreach sreach){
        List<fgsbgl> temp = new ArrayList<>();
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
            temp = session.selectList("fgsbglistbydate",sreach);
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

    public int fgsallcountsbydate(sreach sreach){
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
            counts = session.selectOne("fgsallcountsbydate",sreach);
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

    public List<fgsbgl> fgsbglist(sreach sreach){
        List<fgsbgl> temp = new ArrayList<>();
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
            temp = session.selectList("fgsbglist",sreach);
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

    public List<fgsbgl> fgsshbglist(sreach sreach){
        List<fgsbgl> temp = new ArrayList<>();
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
            temp = session.selectList("fgsshbglist",sreach);
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

    public int fgsallcounts(){
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
            counts = session.selectOne("fgsallcounts");
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

    public int fgsshallcounts(){
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
            counts = session.selectOne("fgsshallcounts");
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

    public List<fgsbgl> fgsfindbglsbybgnumanddate(sreach sreach){
        List<fgsbgl> temp = new ArrayList<>();
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
            temp = session.selectList("fgsfindbglsbybgnumanddate",sreach);
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

    public int fgsallcountsbybgnumanddate(sreach sreach){
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
            counts = session.selectOne("fgsallcountsbybgnumanddate",sreach);
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

    public List<fgsbgl> fgsfindbglsbybgnum(sreach sreach){
        List<fgsbgl> temp = new ArrayList<>();
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
            temp = session.selectList("fgsfindbglsbybgnum",sreach);//查询可能是2条记录
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

    public int fgsallcountsbybgnum(sreach sreach){
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
            counts = session.selectOne("fgsallcountsbybgnum",sreach);
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

    public List<fgsbgl> fgsselectbglbyzldate(sreach sreach){
        List<fgsbgl> temp = new ArrayList<>();
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
            temp = session.selectList("fgsfindbglsbybgnumanddate",sreach);
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

    public int fgsallcountsbyzldate(sreach sreach){
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
            counts = session.selectOne("fgsallcountsbyzldate",sreach);
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

    public List<fgsbgl> fgsbglistbyzuoluo(sreach sreach){
        List<fgsbgl> temp = new ArrayList<>();
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
            temp = session.selectList("fgsselectBaoGaoListbyzuoluo",sreach);
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

    public int fgsallcountsbyzuoluo(sreach sreach){
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
            counts = session.selectOne("fgsallcountsbyzuoluo",sreach);
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

    public List<fgsbgl> fgsselectbglbypronameanddate(sreach sreach){
        List<fgsbgl> temp = new ArrayList<>();
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
            temp = session.selectList("fgsselectbglbypronameanddate",sreach);
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

    public int fgsallcountbglbypronameandate(sreach sreach){
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
            counts = session.selectOne("fgsallcountbglbypronameandate",sreach);
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

    public List<fgsbgl> fgsselectbglbyproname(sreach sreach){
        List<fgsbgl> temp = new ArrayList<>();
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
            temp = session.selectList("fgsselectbglbyproname",sreach);
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

    public int fgsallcountbglbyproname(sreach sreach){
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
            counts = session.selectOne("fgsallcountbglbyproname",sreach);
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

    public List<fgsbgl> fgsselectbglbycqranddate(sreach sreach){
        List<fgsbgl> temp = new ArrayList<>();
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
            temp = session.selectList("fgsselectbglbycqranddate",sreach);
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

    public int fgscountbycqrandate(sreach sreach){
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
            counts = session.selectOne("fgscountbycqrandate",sreach);
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

    public List<fgsbgl> fgsselectBaoGaoListbycqr(sreach sreach){
        List<fgsbgl> temp = new ArrayList<>();
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
            temp = session.selectList("fgsselectBaoGaoListbycqr",sreach);
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

    public int fgscountbycqr(sreach sreach){
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
            counts = session.selectOne("fgscountbycqr",sreach);
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

    public List<BaoGao> fgsfindbgsbybglid(int bglid){
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
            bgs = session.selectList("fgsfindbgsbybglid",bglid);//查询可能是2条记录
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

    public fgsbgl fgsfindbglbyid(int bglid){
        fgsbgl temp = new fgsbgl();
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
            temp = session.selectOne("fgsfindbglbyid",bglid);
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


    public void fgsupdatebglbybglid(fgsbgl bgl){
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
            session.update("fgsupdatebglbybglid",bgl);
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


    public void fgsdelbgbybglid(int bglid){

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
            session.delete("fgsdelbgbybglid",bglid);
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


    public int fgsfindbglidbystrave(String bgnum){
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
            bglid = session.selectOne("fgsfindbglidbystrave",bgnum);
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


    public void fgsupdatebglstatebyid(int bglid){
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
            session.update("fgsupdatebglstatebyid",bglid);
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

    public List<fgsbgl> fgsshlistbydate(sreach sreach){
        List<fgsbgl> temp = new ArrayList<>();
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
            temp = session.selectList("fgsbglistbydate",sreach);
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

    public int fgsshcountbydate(sreach sreach){
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
            counts = session.selectOne("fgsshcountbydate",sreach);
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

    public void fgsupdatebglshstatebyid(int  bglid){
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
            session.update("fgsupdatebglshstatebyid",bglid);
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

    public void fgsbackupdate(fgsbgl  bgl){
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
            session.update("fgsbackupdate",bgl);
            session.commit();
			System.out.println("有没有更新啊啊 ，怎么根本看不到啊");
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


