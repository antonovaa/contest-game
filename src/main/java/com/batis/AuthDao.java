//package com.batis;
//
//import com.model.Data;
//import com.model.Person;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.PostConstruct;
//import java.time.LocalDateTime;
//import java.util.List;
//
//
//@Repository
//public class AuthDao {
//
//
//  private final SqlSessionFactory sqlSessionFactory;
//  private final JdbcTemplate jdbcTemplate;
//
//
//  @Autowired
//  public AuthDao(SqlSessionFactory sqlSessionFactory, JdbcTemplate jdbcTemplate) {
//    this.sqlSessionFactory = sqlSessionFactory;
//    this.jdbcTemplate = jdbcTemplate;
//  }
//
//  @PostConstruct
//  public void addAuthEventMapper() {
//    //  sqlSessionFactory.getConfiguration().addMapper(AuthEventMapper.class);
//  }
//
//  public void save(Data data) {
//    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
//      AuthEventMapper authEventMapper = sqlSession.getMapper(AuthEventMapper.class);
//      authEventMapper.saveLoginEvent(data);
//      sqlSession.commit();
//    }
//  }
//
//  public void closeSession(String jSessionId, Data data) {
//    SqlSession sqlSession = sqlSessionFactory.openSession();
//    try (sqlSession) {
//      AuthEventMapper authEventMapper = sqlSession.getMapper(AuthEventMapper.class);
//      LocalDateTime closeDate = LocalDateTime.now();
//      authEventMapper.closeSession(jSessionId, closeDate, data);
//      sqlSession.commit();
//    }
//  }
//
////    public Data getPersonByLogin(int data) {
////        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
////            AuthEventMapper authEventMapper = sqlSession.getMapper(AuthEventMapper.class);
////            return authEventMapper.getPersonByLogin(data);
////        }
////    }
//
//  public Person getdatabyid(String data) {
//    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
//      AuthEventMapper authEventMapper = sqlSession.getMapper(AuthEventMapper.class);
//      return authEventMapper.getPersonByLogin(data);
//    }
//  }
//
//  public List<Person> getAllPerson() {
//    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
//      AuthEventMapper authEventMapper = sqlSession.getMapper(AuthEventMapper.class);
//      return authEventMapper.getAllPerson();
//    }
//  }
////    public void updateLastRequests(Collection<String> jSessionIds) {
////        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
////            AuthEventMapper authEventMapper = sqlSession.getMapper(AuthEventMapper.class);
////            String[] jSessionIdArray = jSessionIds.toArray(new String[jSessionIds.size()]);
////            authEventMapper.updateLastRequests(jSessionIdArray);
////            sqlSession.commit();
////        }
////    }
//
//
//  public interface AuthEventMapper {
//
//    void saveLoginEvent(Data data);
//
//    // void updateLastRequests(@Param("jSessionIds") String[] jSessionId);
//
////        @Select("select * from data where id = #{id}")
////        public Data getPersonByLogin(int id);
//
//    @Select("select * from person where login = #{login}")
//    public Person getPersonByLogin(String login);
//
////        public static Person getPersonByLogin(String login)
////        {
////            return new Person();
////        }
//
//    //@Select("select * from public.person")
//    public List<Person> getAllPerson();
//
//    void closeSession(
//        String jSessionId,
//        LocalDateTime closeDate,
//        Data data
//    );
//  }
//}