(ns hello
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [greeter :as greeter]))

(defn respond-hello [request]
  (let [nm (get-in request [:query-params :name]) 
    resp (greeter/greeting-for nm)]
    {:status 200 :body resp}))

(def routes
  (route/expand-routes
   #{["/greet" :get respond-hello :route-name :greet]}))

(def service-map 
  {::http/routes routes
   ::http/type :jetty
   ::http/port 8890})

(defn start []
  (http/start (http/create-server service-map)))

(defonce server (atom nil))

(defn start-dev []
  (reset! server
          (http/start (http/create-server
                       (assoc service-map
                              ::http/join? false)))))

(defn stop-dev []
  (http/stop @server))

(defn restart []
  (stop-dev)
  (start-dev))