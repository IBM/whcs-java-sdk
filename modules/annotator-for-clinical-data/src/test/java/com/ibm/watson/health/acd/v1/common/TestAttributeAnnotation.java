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
package com.ibm.watson.health.acd.v1.common;


import java.util.List;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.AttributeValueAnnotation;
import com.ibm.watson.health.acd.v1.model.Concept;
import com.ibm.watson.health.acd.v1.model.Disambiguation;
import com.ibm.watson.health.acd.v1.model.InsightModelData;
import com.ibm.watson.health.acd.v1.model.InsightModelDataDiagnosis;
import com.ibm.watson.health.acd.v1.model.InsightModelDataMedication;
import com.ibm.watson.health.acd.v1.model.InsightModelDataNormality;
import com.ibm.watson.health.acd.v1.model.InsightModelDataNormalityUsage;
import com.ibm.watson.health.acd.v1.model.InsightModelDataProcedure;
import com.ibm.watson.health.acd.v1.model.InsightModelDataTask;
import com.ibm.watson.health.acd.v1.model.InsightModelDataUsage;
import com.ibm.watson.health.acd.v1.model.Temporal;

public class TestAttributeAnnotation {

	public static void testAttributeValue(AttributeValueAnnotation annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Concept concept = annotation.getConcept();
		if (concept != null) {
			Assert.assertNotNull(concept.getUid());
		}
		Assert.assertNotNull(annotation.getCoveredText());

		Disambiguation disambigData = annotation.getDisambiguationData();
		if (disambigData != null) {
			Assert.assertNotNull(disambigData.getValidity());
		}
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		if (annotation.getCptCode() != null) {
			Assert.assertTrue(annotation.getCptCode().length() > 0);
		}
		if (annotation.getIcd10Code() != null) {
			Assert.assertTrue(annotation.getIcd10Code().length() > 0);
		}
		if (annotation.getIcd9Code() != null) {
			Assert.assertTrue(annotation.getIcd9Code().length() > 0);
		}
		if (annotation.getId() != null) {
			Assert.assertTrue(annotation.getId().length() > 0);
		}
		if (annotation.getLoincId() != null) {
			Assert.assertTrue(annotation.getLoincId().length() > 0);
		}
		if (annotation.getMeshId() != null) {
			Assert.assertTrue(annotation.getMeshId().length() > 0);
		}
		if (annotation.getName() != null) {
			Assert.assertTrue(annotation.getName().length() > 0);
		}
		if (annotation.getNciCode() != null) {
			Assert.assertTrue(annotation.getNciCode().length() > 0);
		}
		if (annotation.getPreferredName() != null) {
			Assert.assertTrue(annotation.getPreferredName().length() > 0);
		}
		if (annotation.getRxNormId() != null) {
			Assert.assertTrue(annotation.getRxNormId().length() > 0);
		}
		if (annotation.getSectionNormalizedName() != null) {
			Assert.assertEquals(annotation.getSectionNormalizedName(), Constants.SECTION_NAME);
		}
		if (annotation.getSnomedConceptId() != null) {
			Assert.assertTrue(annotation.getSnomedConceptId().length() > 0);
		}
		if (annotation.getSource() != null) {
			Assert.assertTrue(annotation.getSource().length() > 0);
		}
		if (annotation.getSourceVersion() != null) {
			Assert.assertTrue(annotation.getSourceVersion().length() > 0);
		}
		Assert.assertNull(annotation.getType());
		Long uid = annotation.getUid();
		if (uid != null) {
			Assert.assertTrue(uid > 0);
		}
		if (annotation.getInsightModelData() != null && !annotation.getInsightModelData().isEmpty()) {
			InsightModelData imd = annotation.getInsightModelData();
			if (imd.getMedication() != null) {
				Assert.assertTrue(!imd.getMedication().isEmpty());
				InsightModelDataMedication imdMed = imd.getMedication();
				if (imdMed.getUsage() != null) {
					Assert.assertTrue(!imdMed.getUsage().isEmpty());
					InsightModelDataUsage imdMedUsage = imdMed.getUsage();
					Float explicitScore = imdMedUsage.getExplicitScore();
					if (explicitScore != null) {
						Assert.assertTrue(explicitScore >= 0);
					}
				}
			}
			if (imd.getProcedure() != null) {
				Assert.assertTrue(!imd.getProcedure().isEmpty());
				InsightModelDataProcedure imdProc = imd.getProcedure();
				if (imdProc.getTask() != null) {
					Assert.assertTrue(!imdProc.getTask().isEmpty());
					InsightModelDataTask imdProcTask = imdProc.getTask();
					Float clinicalAssessScore = imdProcTask.getClinicalAssessmentScore();
					if (clinicalAssessScore != null) {
						Assert.assertTrue(clinicalAssessScore >= 0);
					}
				}
			}
			if (imd.getDiagnosis() != null) {
				Assert.assertTrue(!imd.getDiagnosis().isEmpty());
				InsightModelDataDiagnosis imdDiag = imd.getDiagnosis();
				if (imdDiag.getUsage() != null) {
					Assert.assertTrue(!imdDiag.getUsage().isEmpty());
					InsightModelDataUsage imdDiagUsage = imdDiag.getUsage();
					Float explicitScore = imdDiagUsage.getExplicitScore();
					if (explicitScore != null) {
						Assert.assertTrue(explicitScore >= 0);
					}
				}
			}
			if (imd.getNormality() != null) {
				Assert.assertTrue(!imd.getNormality().isEmpty());
				InsightModelDataNormality imdNorm = imd.getNormality();
				if (imdNorm.getUsage() != null) {
					Assert.assertTrue(!imdNorm.getUsage().isEmpty());
					InsightModelDataNormalityUsage imdNormUsage = imdNorm.getUsage();
					Float normalScore = imdNormUsage.getNormalScore();
					if (normalScore != null) {
						Assert.assertTrue(normalScore >= 0);
					}
				}
			}
		}
		if (annotation.getCcsCode() != null) {
			Assert.assertTrue(annotation.getCcsCode().length() > 0);
		}
		if (annotation.getHccCode() != null) {
			Assert.assertTrue(annotation.getHccCode().length() > 0);
		}
		if (annotation.getRuleId() != null) {
			Assert.assertTrue(annotation.getRuleId().length() > 0);
		}
		if (annotation.getDerivedFrom() != null) {
			Assert.assertTrue(annotation.getDerivedFrom().size() > 0);
		}
		if (annotation.getValues() != null) {
			Assert.assertTrue(annotation.getValues().size() > 0);
		}
		List<Temporal> temporals = annotation.getTemporal();
		if (temporals != null) {
			Assert.assertTrue(temporals.size() > 0);
			for (Temporal temporal : temporals) {
				Assert.assertTrue(temporal.getBegin() > -1);
				Assert.assertTrue(temporal.getEnd() > temporal.getBegin());
				Assert.assertNotNull(temporal.getCoveredText());
			}
		}
	}
}
