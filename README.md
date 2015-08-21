# alpha
An app for learning how a Clojure web app works. Actually, I wanted to learn how any web app works. I'm also a beginner at Clojure. So, that's fun. :-)

## What?
This is Alex. I have help from Jason. 

I intend this as a kata &mdash; for me &mdash; to repeat until it's second nature.

I'll describe the steps as best I can. If you decide to follow these steps, and you get stuck, I'll try and help. You'll find me on twitter and on the gmails as onealexharms.

And look. Somebody will say it's too basic. Somebody else will get lost. My intent was to make it as accessible as possible. If it's too slow/easy for you, go read some docs. <3

## The steps

0. Setup
1. Create a new project
2. Put it in Github
3. Serve web pages locally
4. Create a web server
5. Deploy the app
6. Add styling to the html
7. Extract stuff to new files

### 0. Setup

You'll need Java and Leiningen installed. (Clojure comes with Leiningen, I'm told.) I didn't do this step recently, so I'm not going to provide instructions for it. Use the Google, ask your Clojure friend, or ask me.

Also, I'm on a Mac. If you're not, YMMV.

### 1. Create a new project

In the directory where you put projects, do this:

(Note that **$ is the prompt.** Don't type that part.)

```
$ lein new project_name
$ cd project_name
```

(You can call it *project_name* if you want. I'm figuring you'll pick something else.)

**Check for success:** you run `lein test` and you see a failing test. (Leiningen comes with one.)

### 2. Put it in Github

This is a reminder of the steps, but it assumes you have a Github account and know basically how to use it.

In your *project_name* directory

```
$ git init  
$ git add -A   
$ git commit -m "Initial commit"  
```
Go to Github in your browser. Create a repo. Get the *url_for_your_repo*

`$ git remote add origin url_for_your_repo
`$ git push -u origin master

**Check for success:** See your stuff on Github.

### 3. Serve web pages locally

[Ring](https://github.com/ring-clojure/ring) is what lets you talk to the web without a huge hassle. It's our only dependency. No fancy frameworks for this learning project. Leiningen is going to download your dependencies for you, so you don't need to install or anything. 

Open *project.clj* in your favorite editor to add the Ring dependency. Find the (defproject ...) function, and add:

`:dependencies [[ring/ring-core "x.x.x"]]` where *x.x.x* is the current version (Today it's "1.4.0"). If there's already a dependency, just add the ring part.

Also add the *[lein-ring](https://github.com/weavejester/lein-ring)* plugin.

`:dependencies [[lein-ring "x.x.x"]]` (Today the version is "0.9.6")

Check how that went by doing

`$ lein deps`

This downloads dependencies. It's optional, because that happens all the time, but it will tell you if you're okay so far. If things are whack, and you're new to Clojure like me, go squint at your parentheses and your curly braces. That's probably it.

Now you get to edit *core.clj* to give it a **page handler**. This is the key to happiness. It's the function that will respond to requests from a browser to serve a web page. (Ring receives the request from a browser, and uses the page handler you specify to figure out what to give the browser in response.)

From your *project_name* directory, you'll find *core.clj* in *src/project_name*. Oddly (to me), *project_name* occures in several places.

```
(defn page-handler
  [request]
  {:body "Hello, World."})
```

Now edit *core.clj* again, to tell ring what we named our page-handler. Add a line to (defproject ...)

`:ring {:handler project-name.core/page-handler}`

You did it. Now run 

`lein ring server`

**Check for success:** If it doesn't open a browser for you, the terminal window will tell you "started on port xxxx" (mine is 3000). Browse to localhost:3000 (or whatever) and you should see your Hello, World.

## License

Copyright © 2015 Maitria

License: You can use this to learn along with me! You can also share and modify (eg. fork) it. You agree we're not liable if you are harmed somehow by your use of this. You agree not to sell it or use it in your profit-making endeavor without permission. And you agree not to do anything with it that you could reasonably anticipate would cause harm to us or Maitria. That's all I got.
