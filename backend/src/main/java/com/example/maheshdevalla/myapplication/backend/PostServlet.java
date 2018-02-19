package com.example.maheshdevalla.myapplication.backend;

import com.example.maheshdevalla.myapplication.backend.data.DataItem;
import com.example.maheshdevalla.myapplication.backend.data.EntryDataStore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Receive information from mobile to update service database
 */
public class PostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntryDataStore.deleteAll();
        String res = req.getParameter("data");
        System.out.println(res);
        if (res == null || res.length() == 0) {
            resp.sendRedirect("/query.do");
            return;
        }

        String []entry = res.split("#");
        for (int i = 0; i < entry.length; i++) {
            String []entryItem = entry[i].split(",");
            DataItem item = new DataItem(entryItem[0], entryItem[1], entryItem[2], entryItem[3], entryItem[4],
                    entryItem[5], entryItem[6], entryItem[7], entryItem[8], entryItem[9], entryItem[10]);
            EntryDataStore.add(item);
        }
        resp.sendRedirect("/query.do");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
