/*
 * Copyright (c) 2022 AXA France. Licensed under the AXA France License (the "License"); you may not use this file except in compliance with
 * the License. A copy of the License can be found in the LICENSE.TXT file distributed together with this file. Unless required by
 * applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package fr.java.bases;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class MiscFunctions {
    
    public static <T> Long count(List<T> originalLst) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#count");
    }
    
    public static <T> List<T> distinct(List<T> originalLst) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#distinct");
    }
    
    public static <T> Optional<T> findAny(List<T> originalLst) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#findAny");
    }
    
    public static <T> Optional<T> findFirst(List<T> originalLst) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#findFirst");
    }
    
    public static <T> Optional<T> min(List<T> originalLst, Comparator<? super T> comparator) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#min");
    }
    
    public static <T> Optional<T> max(List<T> originalLst, Comparator<? super T> comparator) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#max");
    }
    
    public static <T> Optional<T> reduce(List<T> orignalLst, BinaryOperator<T> accumulator) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#reduce");
    }
}
