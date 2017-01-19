package com.xcloud.qixinspy.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xcloud.qixinspy.db.IBaseDao;
import com.xcloud.qixinspy.db.model.QyzyryVO;

public class QyzyryDao implements IBaseDao<QyzyryVO> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(QyzyryVO t) {
        String sql = "insert into yj_qyzyry (zjh,xm, zw, dh, dz) values (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[] { t.getZjh(), t.getXm(), t.getZw(), t.getDh(), t.getDz() });
    }

    @Override
    public int deleteById(QyzyryVO t) {
        String sql = "delete from yj_qyzyry where zjh=?";
        return jdbcTemplate.update(sql, new Object[] { t.getZjh() });
    }

    @Override
    public int updateById(QyzyryVO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public QyzyryVO findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<QyzyryVO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<QyzyryVO> findByCondition(QyzyryVO cond) {
        // TODO Auto-generated method stub
        return null;
    }

}
