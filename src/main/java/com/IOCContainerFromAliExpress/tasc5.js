const fs = require('fs')
const dir = __dirname + '/'
fs.readdir (dir, (err,files) => {
    if(err) {
        console.error ("this error: " + err)
        return
    }
    console.log("files in block " + files)
})
try {
    const data = fs.readFileSync('C:\Users\Yurij\Dropbox')
    const files = fs.readdirSync(dir)
    fs.
    console.log("Files in pack " + files)
    console.log(data)
} catch (err) {
    console.error("this error 2: " + err)
}