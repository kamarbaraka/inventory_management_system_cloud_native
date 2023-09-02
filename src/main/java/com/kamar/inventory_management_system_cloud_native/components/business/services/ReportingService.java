package com.kamar.inventory_management_system_cloud_native.components.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * the reporting service.
 * @author kamar baraka.*/

@Service
public class ReportingService {


    /*private final IReportEngine reportEngine;

    @Autowired
    public ReportingService(IReportEngine reportEngine) {
        this.reportEngine = reportEngine;
    }

    public byte[] generateOrderReport() throws Exception{

        IReportRunnable report = reportEngine.openReportDesign("reports/order_report.rptdesign");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        IRunAndRenderTask task = reportEngine.createRunAndRenderTask(report);
        RenderOption option = new HTMLRenderOption();
        option.setOutputFormat("html");
        option.setOutputStream(outputStream);

        task.setRenderOption(option);
        task.run();
        task.close();

        return outputStream.toByteArray();
    }*/
}
