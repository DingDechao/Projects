package com.ddc.projects.java11.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ddc.projects.java11.entity.Title;
import com.ddc.projects.java11.jdbc.DBManager;

public class TitleDAO {
    public Title quaryById(Title bd) {
        int id = bd.getId();
        try {
            String sql = "select * from tb_title where id>1";
            DBManager dbm = new DBManager();
            Connection conn = dbm.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int iid = rs.getInt("id");
            int uid = rs.getInt("uid");
            int cid = rs.getInt("cid");
            String title = rs.getString("title");
            String createTime = rs.getString("createTime");
            int click = rs.getInt("click");
            bd = new Title(id, uid, cid, title, createTime, click);
            dbm.closeconn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bd;
    }

    public static void main(String[] args) {
        TitleDAO tdao = new TitleDAO();
        Title bd = null;
        List<Title> list = (List<Title>) tdao.quaryById(bd);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId() + "/" + list.get(i).getCid() + "/" + list.get(i).getUid() + "/" + list.get(i).getTitle() + "/" + list.get(i).getCreateTime() + "/" + list.get(i).getClick());
        }
    }
}

