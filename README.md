# Document Object Model -to- Key Value (dom2kv) POC

This code originally was in https://github.com/vorburger/opendaylight-etcd/ but ended up not being used there, so parked here.

It was removed from opendaylight-etcd in https://github.com/vorburger/opendaylight-etcd/pull/13, like this:

    sudo dnf install git-subtree
    git subtree split -P dom2kv -b dom2kv
    git rm -r dom2kv/
    git commit -m"git rm -r dom2kv/"

    cd ..
    mkdir dom2kv
    cd dom2kv
    git init
    git pull ../opendaylight-etcd dom2kv
 
