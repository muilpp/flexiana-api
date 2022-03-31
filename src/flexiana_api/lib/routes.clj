(ns flexiana-api.lib.routes
  (:require
    [flexiana-api.lib.api :as api])
  (:gen-class))

(defn get-scramble
  "Response whether a scramble is found"
  [s1 s2]
  {:status 200
   :headers {"Content-Type" "application/json" "Access-Control-Allow-Origin" "http://localhost:8080"}
   :body (-> (String/valueOf(api/scramble? s1 s2)))}
)