/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.fhirengine.search.filter

import com.google.fhirengine.search.impl.ResourceIdQuery
import org.hl7.fhir.r4.model.Resource

/** Interface to specify filtering criteria for search. */
interface FilterCriterion {
    fun and(filterCriterion: FilterCriterion): FilterCriterion =
        and(this, filterCriterion)

    fun or(filterCriterion: FilterCriterion): FilterCriterion =
        or(this, filterCriterion)

    /** Returns the [ResourceIdQuery] that can be used to construct a query. */
    fun <R : Resource> query(clazz: Class<R>): ResourceIdQuery
}