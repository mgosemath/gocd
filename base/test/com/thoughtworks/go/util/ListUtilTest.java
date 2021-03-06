/*************************GO-LICENSE-START*********************************
 * Copyright 2014 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *************************GO-LICENSE-END***********************************/

package com.thoughtworks.go.util;

import java.util.ArrayList;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class ListUtilTest {
    @Test
    public void shouldGetItemForGivenKey(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("foo");
        list.add("bar");
        String result = ListUtil.find(list, new ListUtil.Condition() {
            @Override
            public <String> boolean isMet(String item) {
                return item == "bar";
            }
        });
        assertThat(result, is("bar"));
    }

    @Test
    public void shouldGetNullIfPropertyNotFoundForGivenKey(){
        String result = ListUtil.find(new ArrayList<String>(), new ListUtil.Condition() {
            @Override
            public <String> boolean isMet(String item) {
                return item == "lkhg";
            }
        });
        assertThat(result, is(nullValue()));
    }
}
