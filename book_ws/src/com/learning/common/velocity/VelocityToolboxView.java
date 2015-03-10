package com.learning.common.velocity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;

/**
 * Subclassing to add extra fields into velocity context, such as $base.
 */
public class VelocityToolboxView extends org.springframework.web.servlet.view.velocity.VelocityToolboxView {

    protected Context createVelocityContext(Map model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Context context = super.createVelocityContext(model, request, response);
        context.put("base", request.getContextPath());
        return context;
    }
}
