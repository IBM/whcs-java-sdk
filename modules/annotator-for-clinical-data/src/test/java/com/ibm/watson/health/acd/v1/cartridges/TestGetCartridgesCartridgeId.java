/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.health.acd.v1.cartridges;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.common.Constants;
import com.ibm.watson.health.acd.v1.model.AcdCartridges;
import com.ibm.watson.health.acd.v1.model.AcdCartridgesList;
import com.ibm.watson.health.acd.v1.model.CartridgesGetIdOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesGetIdOptions.Builder;

/**
*
* Class for testing GET /v1/cartridges/{id}.
*
*/
public class TestGetCartridgesCartridgeId extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetCartridgesCartridgeId() {
		super();
		try {
			this.setUp();
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCartridgesCartridgeId() {
		CartridgesGetIdOptions options = new CartridgesGetIdOptions.Builder().id(Constants.CARTRIDGE_ID).build();

		Response<AcdCartridges> response = null;
		try {
			ServiceCall<AcdCartridges> sc = service.cartridgesGetId(options);
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetCartridgesCartridgeId: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			AcdCartridges cartridge = response.getResult();
			Assert.assertNotNull(cartridge.getId());
		}
	}

	@Test
	public void testGetCartridgesCartridgeIdBuilder() {
		Builder builder = new CartridgesGetIdOptions.Builder(Constants.CARTRIDGE_ID);

		Response<AcdCartridges> response = null;
		try {
			ServiceCall<AcdCartridges> sc = service.cartridgesGetId(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetCartridgesCartridgeIdBuilder: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			AcdCartridges cartridge = response.getResult();
			Assert.assertNotNull(cartridge.getId());
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		CartridgesGetIdOptions options = new CartridgesGetIdOptions.Builder().id(Constants.CARTRIDGE_ID).build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
