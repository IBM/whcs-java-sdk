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
package com.ibm.watson.health.iml.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getFields options.
 */
public class GetFieldsOptions extends GenericModel {

  protected String corpus;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;

    private Builder(GetFieldsOptions getFieldsOptions) {
      this.corpus = getFieldsOptions.corpus;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param corpus the corpus
     */
    public Builder(String corpus) {
      this.corpus = corpus;
    }

    /**
     * Builds a GetFieldsOptions.
     *
     * @return the new GetFieldsOptions instance
     */
    public GetFieldsOptions build() {
      return new GetFieldsOptions(this);
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetFieldsOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }
  }

  protected GetFieldsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpus,
      "corpus cannot be empty");
    corpus = builder.corpus;
  }

  /**
   * New builder.
   *
   * @return a GetFieldsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the corpus.
   *
   * Corpus name.
   *
   * @return the corpus
   */
  public String corpus() {
    return corpus;
  }
}

