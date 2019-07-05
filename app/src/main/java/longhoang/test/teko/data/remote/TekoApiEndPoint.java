/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */
package longhoang.test.teko.data.remote;

import longhoang.test.teko.BuildConfig;

public final class TekoApiEndPoint {
    public static final String ENDPOINT_BASE_URL = BuildConfig.BASE_URL;
    public static final String ENDPOINT_TEKO_SEARCH = BuildConfig.BASE_URL + "/search/?channel={channel}&visitorId={visitorId}&q={q}&terminal={terminal}";
    public static final String ENDPOINT_TEKO_DETAIL = BuildConfig.BASE_URL + "/products/{product_sku}";

    private TekoApiEndPoint() {
        // This class is not publicly instantiable
    }
}
