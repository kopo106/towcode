package com.hnkypg.dao;

import com.hnkypg.pojo.anli;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by python on 2017-8-5.
 */
public class AnliDao {
    public void insertAnli(List<anli> cts){
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

                session.insert("insertAnli",cts.get(i));

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
}
