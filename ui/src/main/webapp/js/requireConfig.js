var require = {
    shim: {
        underscore: {
            exports: "_"
        },
        jquery: {
            exports: "$"
        },
        react: {
            exports: "React"
        },
        reactdom: {
            exports: "ReactDOM"
        }
    },
    packages: [

    ],
	config: {
		babel: {
			sourceMaps: "inline",
			fileExtension: ".jsx"
		}
	},
    paths: {
    	// Remote packages
        browser: "//cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min",
        reactdom: "//fb.me/react-dom-15.0.2",
        react: "//fb.me/react-15.0.2",
        jquery: "//ajax.googleapis.com/ajax/libs/jquery/2.2.3/jquery.min",
        
        // Manual local package 
        babel: "../bower_components/requirejs-react-jsx/babel-5.8.34.min",
        text: "../bower_components/requirejs-text/text",
        
        // Grunt added packages
    }
};
