package com.xcloud.qixinspy.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xcloud.qixinspy.db.IBaseDao;
import com.xcloud.qixinspy.db.model.QygdxxVO;

public class QygdxxDao implements IBaseDao<QygdxxVO> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(QygdxxVO t) {
        String sql = "insert into yj_qygdxx (zjh, gdlx, gd, rjcz, sjcz) values (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[] { t.getZjh(), t.getGdlx(), t.getGd(), t.getRjcz(), t.getSjcz() });
    }

    public int deleteById(QygdxxVO t) {
        String sql = "delete from yj_qygdxx where zjh=?";
        return jdbcTemplate.update(sql, new Object[] { t.getZjh() });
    }

    @Override
    public int updateById(QygdxxVO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public QygdxxVO findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<QygdxxVO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<QygdxxVO> findByCondition(QygdxxVO cond) {
        // TODO Auto-generated method stub
        return null;
    }

}
