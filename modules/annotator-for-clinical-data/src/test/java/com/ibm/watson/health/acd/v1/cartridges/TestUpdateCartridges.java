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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.HttpStatus;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.common.Constants;
import com.ibm.watson.health.acd.v1.model.AcdCartridges;
import com.ibm.watson.health.acd.v1.model.CartridgesGetIdOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesPostMultipartOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesPostMultipartOptions.Builder;
import com.ibm.watson.health.acd.v1.model.CartridgesPutMultipartOptions;
import com.ibm.watson.health.acd.v1.model.DeleteUserSpecificArtifactsOptions;
import com.ibm.watson.health.acd.v1.model.DeployCartridgeResponse;

/**
*
* Class for testing PUT /v1/cartridges.
*
*/
public class TestUpdateCartridges extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	private Response<DeployCartridgeResponse> createCartridgeForUpdateTest(File cartridgeFile) {
		Boolean fileFound = true;
		CartridgesPostMultipartOptions options = null;
		try {
			options = new CartridgesPostMultipartOptions.Builder().archiveFile(cartridgeFile).build();
		} catch (FileNotFoundException e) {
			fileFound = false;
		}
		Assert.assertTrue(fileFound);
		Assert.assertTrue(options != null);

		Response<DeployCartridgeResponse> response = null;
		try {
			ServiceCall<DeployCartridgeResponse> sc = service.cartridgesPostMultipart(options);
			response = sc.execute();
		} catch (ServiceResponseException e1) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testUpdateCartridges (Create): Service returned status code "
					+ e1.getStatusCode() + ": " + e1.getMessage());
			System.out.println("Detailed error info:\n" + e1.getDebuggingInfo().toString());
		}
		return response;
	}

	private Response<Void> deleteExistingCartridge(File cartridgeFile) {
		Response<Void> resp = null;
		DeleteUserSpecificArtifactsOptions options = new DeleteUserSpecificArtifactsOptions.Builder().build();

		try {
			ServiceCall<Void> sc = service.deleteUserSpecificArtifacts(options);
			resp = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testUpdateCartridges (Delete): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		return resp;
	}

	public TestUpdateCartridges() {
		super();
		try {
			this.setUp();
			service = this.getServiceInstance();
			Map<String, String> headers = new HashMap<String, String>();
			// set tenant ID
			headers.put("X-IBM-Client-Id", "sdk-test");
			service.setDefaultHeaders(headers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateCartridges() {
		File cartridgeFile = new File("src/test/java/com/ibm/watson/health/acd/v1/cartridges/javasdktestcartridge.zip");
		// Determine if cartridge exists
		CartridgesGetIdOptions getOptions = new CartridgesGetIdOptions.Builder().id("javasdktestcartridge").build();
		try {
			ServiceCall<AcdCartridges> sc = service.cartridgesGetId(getOptions);
			sc.execute();
		} catch (ServiceResponseException e) {
			if (e != null && e.getStatusCode() == HttpStatus.NOT_FOUND) {
				createCartridgeForUpdateTest(cartridgeFile);
			}
		}

		Boolean fileFound = true;
		CartridgesPutMultipartOptions options = null;
		try {
			options = new CartridgesPutMultipartOptions.Builder().archiveFile(cartridgeFile).build();
		} catch (FileNotFoundException e) {
			fileFound = false;
		}
		Assert.assertTrue(fileFound);
		Assert.assertTrue(options != null);

		Response<DeployCartridgeResponse> response = null;
		try {
			ServiceCall<DeployCartridgeResponse> sc = service.cartridgesPutMultipart(options);
			response = sc.execute();
		} catch (ServiceResponseException e1) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testUpdateCartridges (Update): Service returned status code "
					+ e1.getStatusCode() + ": " + e1.getMessage());
			System.out.println("Detailed error info:\n" + e1.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			deleteExistingCartridge(cartridgeFile);
		}
	}

	@Test
	public void testUpdateCartridgesBuilder() {
		File cartridgeFile = new File("src/test/java/com/ibm/watson/health/acd/v1/cartridges/javasdktestcartridge.zip");
		// Determine if cartridge exists
		CartridgesGetIdOptions getOptions = new CartridgesGetIdOptions.Builder().id("javasdktestcartridge").build();
		try {
			ServiceCall<AcdCartridges> sc = service.cartridgesGetId(getOptions);
			sc.execute();
		} catch (ServiceResponseException e) {
			if (e != null && e.getStatusCode() == HttpStatus.NOT_FOUND) {
				createCartridgeForUpdateTest(cartridgeFile);
			}
		}

		Boolean fileFound = true;
		Builder builder = null;
		try {
			builder = new CartridgesPostMultipartOptions.Builder().archiveFile(cartridgeFile);
		} catch (FileNotFoundException e) {
			fileFound = false;
		}
		Assert.assertTrue(fileFound);
		Assert.assertTrue(builder != null);

		Response<DeployCartridgeResponse> response = null;
		try {
			ServiceCall<DeployCartridgeResponse> sc = service.cartridgesPostMultipart(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testUpdateCartridgesBuilder (Update): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			if (e.getStatusCode() == HttpStatus.CONFLICT) {
				deleteExistingCartridge(cartridgeFile);
			}
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			deleteExistingCartridge(cartridgeFile);
		}
	}

	@Test
	public void testBuilderFromOptions() {
		CartridgesPostMultipartOptions options = new CartridgesPostMultipartOptions.Builder().build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}