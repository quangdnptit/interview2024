package com.example.demo.interview;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CustomMapQ1 {
    public static class CustomMap {
        String key;
        String val;

        public CustomMap() {
        }

        public String getKey() {
            return key;
        }

        public String get(String key) {
            return val;
        }


        public void setKey(String key) {
            this.key = key;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public CustomMap(String key, String val) {
            this.key = key;
            this.val = val;
        }


        @Override
        public int hashCode() {
            return Objects.hash(key, val);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CustomMap customMap = (CustomMap) o;
            return Objects.equals(key, customMap.key) && Objects.equals(val, customMap.val);
        }
    }

    public static void main(String[] args) {
        CustomMap customMap1 = new CustomMap("1", "23");
        CustomMap customMap2 = new CustomMap("1", "23");

        Set<CustomMap> customMapSet = new HashSet<>();
        customMapSet.add(customMap1);
        customMapSet.add(customMap2);

        System.out.println(customMapSet.size());
        System.out.println(customMap1.get("1"));


    }
}
