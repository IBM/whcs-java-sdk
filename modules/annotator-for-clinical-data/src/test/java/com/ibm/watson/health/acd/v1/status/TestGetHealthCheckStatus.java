/*
 * Copyright 2018, 2020 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.health.acd.v1.status;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.HttpStatus;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.model.GetHealthCheckStatusOptions;
import com.ibm.watson.health.acd.v1.model.GetHealthCheckStatusOptions.Builder;
import com.ibm.watson.health.acd.v1.model.GetHealthCheckStatusOptions.Format;
import com.ibm.watson.health.acd.v1.model.ServiceStatus;

/**
 *
 * Class to test GET /v1/status/health_check.
 *
 */
public class TestGetHealthCheckStatus extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetHealthCheckStatus() {
		super();
		try {
			this.setUp();
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetHealthCheckStatus() {
		GetHealthCheckStatusOptions options = new GetHealthCheckStatusOptions.Builder().build();

		Response<ServiceStatus> response = null;
		try {
			ServiceCall<ServiceStatus> sc = service.getHealthCheckStatus(options);
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetHealthCheckStatus: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertEquals(response.getResult().getServiceState(), "OK");
		}
	}

	@Test
	public void testGetHealthCheckStatusNoOptions() {
		Response<ServiceStatus> response = null;
		try {
			ServiceCall<ServiceStatus> sc = service.getHealthCheckStatus();
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetHealthCheckStatusNoOptions: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertEquals(response.getResult().getServiceState(), "OK");
		}
	}

	@Test
	public void testGetHealthCheckStatusBuilder() {
		Builder builder = new GetHealthCheckStatusOptions.Builder();

		Response<ServiceStatus> response = null;
		try {
			ServiceCall<ServiceStatus> sc = service.getHealthCheckStatus(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetHealthCheckStatusBuilder: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertEquals(response.getResult().getServiceState(), "OK");
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetHealthCheckStatusOptions options = new GetHealthCheckStatusOptions.Builder().build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
