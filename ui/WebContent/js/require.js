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
    jsx: {
    	fileExtension: '.jsx'
	},
    paths: {
	    browser: "//cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min",
	    reactdom: "//fb.me/react-dom-15.0.2",
	    react: "//fb.me/react-15.0.2",
	    jsx: "lib/jsx",
	    text: "lib/text",
	    jquery: "//ajax.googleapis.com/ajax/libs/jquery/2.2.3/jquery.min",
	    underscore: "lib/underscorejs_1.8.3",
        JSXTransformer: "lib/JSXTransformer"
    }
};
