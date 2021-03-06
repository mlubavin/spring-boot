/*
 * Copyright 2012-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.jdbc.init.dependency;

import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Detects beans that initialize a {@link DataSource}. Implementations should be
 * registered in {@code META-INF/spring.factories} under the key
 * {@code org.springframework.boot.jdbc.init.DependsOnDataSourceInitializationDetector}.
 *
 * @author Andy Wilkinson
 * @since 2.5.0
 */
public interface DataSourceInitializerDetector {

	/**
	 * Detect beans defined in the given {@code beanFactory} that initialize a
	 * {@link DataSource}.
	 * @param beanFactory bean factory to examine
	 * @return names of the detected {@code DataSource} initializer beans, or an empty set
	 * if none were detected.
	 */
	Set<String> detect(ConfigurableListableBeanFactory beanFactory);

	/**
	 * Callback indicating that all known {@code DataSourceInitializerDetectors} have been
	 * called and detection of beans that initialize a {@link DataSource} is complete.
	 * @param beanFactory bean factory that was examined
	 * @param dataSourceInitializerNames names of the {@code DataSource} initializer beans
	 * detected by all known detectors
	 */
	default void detectionComplete(ConfigurableListableBeanFactory beanFactory,
			Set<String> dataSourceInitializerNames) {
	}

}
