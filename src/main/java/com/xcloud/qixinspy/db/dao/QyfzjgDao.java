package com.xcloud.qixinspy.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xcloud.qixinspy.db.IBaseDao;
import com.xcloud.qixinspy.db.model.QyfzjgVO;

public class QyfzjgDao implements IBaseDao<QyfzjgVO> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(QyfzjgVO t) {
        String sql = "insert into yj_qyfzjg (zjh, gsmc, fddbr, zczb, clrq) values (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                new Object[] { t.getZjh(), t.getGsmc(), t.getFddbr(), t.getZczb(), t.getClrq() });
    }

    @Override
    public int deleteById(QyfzjgVO t) {
        String sql = "delete from yj_qyfzjg where zjh=?";
        return jdbcTemplate.update(sql, new Object[] { t.getZjh() });
    }

    @Override
    public int updateById(QyfzjgVO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public QyfzjgVO findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<QyfzjgVO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<QyfzjgVO> findByCondition(QyfzjgVO cond) {
        // TODO Auto-generated method stub
        return null;
    }

}
