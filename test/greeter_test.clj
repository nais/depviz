(ns greeter_test
    (:require [clojure.test :refer :all])
    (:require greeter as SUT))

(deftest subtraction
         (is (= 4 (- 7 3))))

(deftest greeting-for
  (is (= "Hello world" (SUT/greeting-for "Audun"))))