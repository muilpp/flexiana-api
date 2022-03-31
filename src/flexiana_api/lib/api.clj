(ns flexiana-api.lib.api)

(defn vec-contains-char?
  "Returns true if the vector contains the map's key at least as many times as the map's value"
  [vec1 map2]
  (and (not= (vec1 (key map2)) nil) (>= (vec1 (key map2)) (val map2)))
  )

(defn scramble?
  "Returns true if a scramble is found, false otherwise"
  [s1 s2]
  (if (or (empty? s1) (empty? s2))
    false
    (let [freq-s1 (frequencies s1)
          freq-s2 (frequencies s2)]

      (->> freq-s2
           (filter #(vec-contains-char? freq-s1 %))
           count
           (= (count freq-s2))
           )))
  )