package com.xcloud.qixinspy.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xcloud.qixinspy.db.IBaseDao;
import com.xcloud.qixinspy.db.model.QyVO;

public class QyDao implements IBaseDao<QyVO> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(QyVO t) {
        String sql = "insert into yj_qy (uuid, zjh, qymc, tyshxydm, zzjgdm, jyzt, gslx, "
                + "clrq, fddbr, yyqx, zczb, fzrq, djjg, qydz, jyfw) values "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                new Object[] { t.getUuid(), t.getZjh(), t.getQymc(), t.getTyshxydm(), t.getZzjgdm(), t.getJyzt(),
                        t.getGslx(), t.getClrq(), t.getFddbr(), t.getYyqx(), t.getZczb(), t.getFzrq(), t.getDjjg(),
                        t.getQydz(), t.getJyfw() });
    }

    public int deleteById(QyVO t) {
        String sql = "delete from yj_qy where uuid=?";
        return jdbcTemplate.update(sql, new Object[] { t.getUuid() });
    }

    public int updateById(QyVO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    public QyVO findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<QyVO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<QyVO> findByCondition(QyVO cond) {
        // TODO Auto-generated method stub
        return null;
    }

}
