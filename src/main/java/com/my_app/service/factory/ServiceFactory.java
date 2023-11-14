package com.my_app.service.factory;

import java.sql.Connection;

public interface ServiceFactory<T> {

	T create(final Connection conn);
}
