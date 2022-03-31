(ns flexiana-api.lib.api-test
  (:require [clojure.test :refer :all]
            [flexiana-api.lib.api :as api]))

(deftest scrumble-test

  (testing "scramble found when scramble present"
    (are [x y] (= x y)
               true (api/scramble? "rekqodlw" "world")
               true (api/scramble? "cedewaraaossoqqyt" "codewars")))

  (testing "no scramble found when no scramble present"
    (is (= false (api/scramble? "katas" "steak"))))

  (testing "no scramble found when first argument empty"
    (is (= false (api/scramble? "" "steak"))))

  (testing "no scramble found when second argument empty"
    (is (= false (api/scramble? "katas" ""))))

  (testing "no scramble found when both arguments empty"
    (is (= false (api/scramble? "" ""))))
)

(deftest vec-contains-map-test
  (testing "found when vector contains character"
    (is (= true (api/vec-contains-char? (frequencies "kata") (first (hash-map \k 1))))))

  (testing "not found when vector does not contain character"
    (is (= false (api/vec-contains-char? (frequencies "kata") (first (hash-map \s 1))))))

  (testing "not found when vector contain character but not enough quantity"
    (is (= false (api/vec-contains-char? (frequencies "kata") (first (hash-map \k 2))))))
  )