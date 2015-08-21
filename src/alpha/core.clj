(ns alpha.core)

(def hello-response  
      {:headers {"content-type" "text/html"}
       :body 
        "<!DOCTYPE html>
        <html>
        <head><link href=\"style.css\" rel=\"stylesheet\"></head>
        <body><p>Hello, World.</p></body>
        </html>"})

(def no-such-page-response
      {:status 404
       :headers {"content-type" "text/html"}
       :body 
        "<!DOCTYPE html>
        <html>
        <head><link href=\"style.css\" rel=\"stylesheet\"></head>
        <body><p class=\"sad\">You've missed the boat.</p></body>
        </html>"})
(def silly-response
      {:body "Foo? Okaaaaaay."})

(def css-response
      {:headers {"content-type" "text/css"}
       :body "p {color: red;} .sad {color: blue;}"})

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
