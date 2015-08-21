(ns alpha.core
  (:require [clojure.java.io :as io]))

(def hello-response  
  {:headers {"content-type" "text/html"}
   :body (slurp (io/resource "hello.html"))})

(def no-such-page-response
  {:status 404
   :headers {"content-type" "text/html"}
   :body (slurp (io/resource "404.html"))})

(def silly-response
  {:body "Foo? Okaaaaaay."})

(def css-response
      {:headers {"content-type" "text/css"}
       :body (slurp (io/resource "style.css"))})

(defn app
  "This is a learning app"
  [request]
  (cond
    (= (:uri request) "/")
      hello-response
    (= (:uri request) "/foo")
      silly-response
    (= (:uri request) "/style.css")
      css-response
    :else
      no-such-page-response))
