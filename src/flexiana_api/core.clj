(ns flexiana-api.core
  (:require
    [compojure.core :refer :all]
    [org.httpkit.server :as server]
    [ring.middleware.defaults :refer :all]
    [flexiana-api.lib.routes :as routes])
  (:gen-class))

(defroutes app-routes
           (GET "/scramble/:s1/:s2" [s1 s2] (routes/get-scramble s1 s2))
)

(defn -main
  []
  (let [port 4000]
    (server/run-server (wrap-defaults #'app-routes api-defaults) {:port port}))
)