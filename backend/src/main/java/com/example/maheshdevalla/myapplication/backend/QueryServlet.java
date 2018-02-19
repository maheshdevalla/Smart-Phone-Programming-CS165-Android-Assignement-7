package com.example.maheshdevalla.myapplication.backend;

import com.example.maheshdevalla.myapplication.backend.data.DataItem;
import com.example.maheshdevalla.myapplication.backend.data.EntryDataStore;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Get all items from database
 */
public class QueryServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<DataItem> list = EntryDataStore.query();
        req.setAttribute("result", list);
        getServletContext().getRequestDispatcher("/query_result.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
