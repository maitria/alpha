(ns alpha.core)

(def hello-response  
      {:headers {"content-type" "text/html"}
       :body 
        "<!DOCTYPE html>
        <html>
        <head><link href=\"style.css\" rel=\"stylesheet\"></head>
        <body><p>Hello, World.</p></body>
        </html>"})

(defn app
  "This is a learning app"
  [request]
  (cond
    (= (:uri request) "/")
      hello-response
    (= (:uri request) "/foo")
      {:body "Foo? Okaaaaaay."}
    (= (:uri request) "/style.css")
      {:headers {"content-type" "text/css"}
       :body "p {color: red;} .sad {color: blue;}"}
    :else
      {:status 404
       :headers {"content-type" "text/html"}
       :body 
        "<!DOCTYPE html>
        <html>
        <head><link href=\"style.css\" rel=\"stylesheet\"></head>
        <body><p class=\"sad\">You've missed the boat.</p></body>
        </html>"}))
