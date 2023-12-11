package com.my_app.api.http_action.city;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;
import com.my_app.model.City;
import com.my_app.service.CityService;
import com.my_app.service.factory.CityServiceFactory;

public class CityApiFindByCountryId extends Action {


	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		final Connection conn = (Connection) req.getAttribute("conn");

		final String countryIdStr = req.getParameter("countryId");

		if (StringUtils.isBlank(countryIdStr)) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

		final Long countryId = Long.parseLong(countryIdStr);

		final CityService cityService = new CityServiceFactory().create(conn);
		final List<City> cities = cityService.findAllByCountryId(countryId);

		Map<String, Object> responseData = new HashMap<>();
		responseData.put("cities", cities);

		Gson gson = new Gson();

		res.setContentType("application/json");
		res.setStatus(HttpServletResponse.SC_OK);
		res.getWriter().write(gson.toJson(responseData));

		return null;
	}

}
